# web_test
made in 2021/11/18 - 2021/11/25  
RPC servers and client.

libraries in python_requirment.txt must be installed on client pc.


myfirstweb：
<br/>
サーバーはクライアントからデータ（タイプ：double）を受信
し，方程式3.8 * x *（1-x）を計算します．ここで，xは受信した
データであり，結果（タイプ：double）をクライアントに返し
ます．<br/>
-ソースコード：サーバーとクライアント<br/>
-結果：500個のランダムサンプルを使用した2D（x-y）プロットが示される．

mysecondweb：
<br/>
サーバーは，クライアントからxとyの2つのデータ（タイプ：
double）を受け取り，原点からの距離（0，0）を計算して，
距離（タイプ：double）を返します．次に、円周率のモンテ
カルロシミュレーションを使用して戻り値を評価します．
<br/>
-ソースコード：サーバーとクライアント<br/>
-結果：500個のランダムサンプルを使用した2D（x-y）プロッ
トと円周率の近似値が示される．
