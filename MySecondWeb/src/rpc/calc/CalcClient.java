import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class CalcClient {
	public static final int LEN = 500;
	private CalcClient() {}
	
	public static void main(String[] args) throws NotBoundException {
		 List<String> dataList = new ArrayList<String>();
		 dataList.add("hits,x,y,pi");
		 int hits = 0;
		for(int i=0;i<LEN;i++){
			Double x = Math.random();
			Double y = Math.random();
			String host = (args.length < 1) ? null : args[0]; 
			try {
				Registry registry = LocateRegistry.getRegistry(host);
				Calc stub = (Calc) registry.lookup("CalcServer");
				Double response = stub.third(x , y);
				if (response <= 1){
					hits= hits + 1;
					Double pi = 4.0* hits /LEN;
					System.out.println("hits:"+String.valueOf(hits)+", x:"+x +", y:"+y +", pi:"+pi);
					dataList.add(String.valueOf(hits)+","+String.valueOf(x)
							+","+String.valueOf(y)+","+String.valueOf(pi));
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		} 
		boolean isSuccess = exportCsv(new File("../../csv/test2.csv"), dataList);
		System.out.println("show result..."+isSuccess);
		CalcClient.callPython();
	}
	
	public static boolean exportCsv(File file, List<String> dataList) {
		boolean isSucess = false;
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			out = new FileOutputStream(file);
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			if (dataList != null && !dataList.isEmpty()) {
				for (String data : dataList) {
					bw.append(data).append("\r\n");
				}
			}
			isSucess = true;
		} catch (Exception e) {
			isSucess = false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
					bw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (osw != null) {
				try {
					osw.close();
					osw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return isSucess;
	}
	public static void callPython(){
		Process proc;
        try {
            proc = Runtime.getRuntime().exec("python ../../py/draw_hm2.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 	
	}
}
