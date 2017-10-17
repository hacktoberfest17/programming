import matplotlib.pyplot as plt
import numpy as np

with plt.xkcd():
    # http://xkcd.com/418/


    fig = plt.figure()

    # scaling axes
    ax = fig.add_axes((0.1, 0.2, 0.8, 0.7))
    ax.spines['right'].set_color('none')
    ax.spines['top'].set_color('none')
    ax.set_ylim([-30, 10])

    # dataset to visualise
    data = np.ones(100)
    data[70:] -= np.arange(30)

    # Assign axis ordinat&abciss
    plt.xlabel("Demand of relationship")
    plt.ylabel("Time")

    plt.annotate(
        'THE DAY I REALIZED\nI COULD BUILD GRAPH\nLIKE XKCD',
        xy=(70, 1), arrowprops=dict(arrowstyle='->'), xytext=(15, -5))
    plt.plot(data)
    fig.savefig("xkcd.pdf", bbox_inches='tight')
