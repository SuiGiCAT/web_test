import matplotlib.pyplot as plt
import pandas as pd
import numpy as np

filepath=r'..\..\csv\test2.csv'

df = pd.read_csv((filepath),encoding = 'gb18030')

x_list = df.x.values.tolist()
y_list = df.y.values.tolist()
hits_list = df.hits.values.tolist()
pi_list = df.pi.values.tolist()

plt.figure(figsize=(10, 5))
plt.subplot(121)
plt.xlabel("x")
plt.ylabel("y")
plt.scatter(x_list, y_list, color = "green", s = 3)

plt.subplot(122)
plt.xlabel("hits")
plt.ylabel("pi")
plt.scatter(hits_list, pi_list, color = "red", s = 3)

plt.savefig('..\..\image\\test2.png', dpi=300)
plt.show()
