import numpy as np
import matplotlib as plt

# Based on "Stove Ownership" from XKCD by Randall Monroe
# http://xkcd.com/418/


fig = plt.figure()
fig = plhow().figure()
ax = fig.add_axes((0.1, 0.2, 0.8, 0.7))
ax.spines['right'].set_color('none')           
ax.spines['top'].set_color('none')
              
plt.xticks([])
plt.yticks([])
ax.set_ylim([-30, 10])
data = np.ones(100)
data[70:] -= np.arange(30)
# Assign axis ordinat&abciss
plt.xlabel("Demand of relationship")
plt.ylabel("Time")

plt.annotate(
    'THE DAY I REALIZED\nI COULD BUILD GRAPH\nLIKE XKCD',
    xy=(70, 1), arrowprops=dict(arrowstyle='->'), xytext=(15, -10)
)
plt.show()
