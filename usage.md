【Windows環境，javac 1.8.0_144，java 1.8.0_144，Python 3.9.2】

1. zip the java file pass:

    D:\homework2\MySecondWeb\src\rpc\calc>dir /a/s/b "*.java" >"source.txt"

2. compile sequence:

    Calc.java
    CalcClient.java
    CalcServer.java

3. compile:

    D:\homework2\MySecondWeb\src\rpc\calc>javac -encoding utf-8 @source.txt -Xlint:unchecked

4. active server: one terminal, the port is given 1099
 
    D:\homework2\MySecondWeb\src\rpc\calc>java CalcServer

5. execute client: another terminal

    D:\homework2\MySecondWeb\src\rpc\calc>java CalcClient



