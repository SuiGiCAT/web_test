import matplotlib.pyplot as plt
import pandas as pd
import numpy as np

filepath = r'..\..\csv\test1.csv'

df = pd.read_csv((filepath),encoding = 'gb18030')

x_list = df.x.values.tolist()
y_list = df.y.values.tolist()

plt.xlabel("x")
plt.ylabel("y")

plt.scatter(x_list, y_list, color = "green", s = 3)
plt.savefig('..\..\image\\test1.png', dpi=300)

plt.show()


