import matplotlib.pyplot as plt
import matplotlib.animation as animation
import random


class Control:
    def __init__(self):
        self.allstop=False
        self.movtf=False
        self.movn=0
        self.con_move=fig.canvas.mpl_connect('motion_notify_event', self.onmove)
        self.con_release=fig.canvas.mpl_connect('button_release_event', self.onrelease)
        self.con_click=fig.canvas.mpl_connect('button_press_event', self.onclick)
        self.con_key=fig.canvas.mpl_connect('key_press_event', self.onkey)

    def onmove(self,event):
        if self.movtf:
            particles[self.movn].position.x = event.xdata
            particles[self.movn].position.y = event.ydata

    def onrelease(self,event):
        particles[self.movn].pbest.set(particles[self.movn].position.x,particles[self.movn].position.y)
        calc_gbest()
        self.movtf=False

    def onclick(self,event):
        for i, a in enumerate(particles):
            if  (event.xdata<a.position.x+1 and event.xdata>a.position.x-1) and (event.ydata<a.position.y+2 and event.ydata>a.position.y-2):
                self.movtf = True
                self.movn = i
                return
            else:
                self.movtf = False

    def onkey(self,event):
        if event.key==' ':
            if self.allstop==False:
                self.allstop=True
            else:
                self.allstop=False


class Vector():
    def __init__(self,x,y):
        self.x=x
        self.y=y

    def mag(self):
        return pow(pow(self.x,2)+pow(self.y,2),0.5)

    def mult(self,k):
        self.x*=k;
        self.y*=k;

    def set(self,x,y):
        self.x=x
        self.y=y


class Particle:
    def __init__(self):
        self.position=Vector(random.randrange(-400,400,1),random.randrange(-400,400,1))
        self.pbest = Vector(self.position.x,self.position.y)
        self.velocity = Vector(0, 0)

    def update_velocity(self):
        omega = 0.95
        c1 = 1.5
        c2 = 1.5
        maximumvel=0.3
        self.velocity.x=omega*self.velocity.x+c1*random.random()*(self.pbest.x-self.position.x)+c2*random.random()*(gbest.x-self.position.x)
        self.velocity.y = omega * self.velocity.y + c1 * random.random() * (self.pbest.y - self.position.y) + c2 * random.random() * (
        gbest.y - self.position.y)

        if self.velocity.mag()>pow(maximumvel,2):
            self.velocity.mult(maximumvel/self.velocity.mag())

    def update_position(self):
        self.position.x=self.position.x+self.velocity.x
        self.position.y=self.position.y+self.velocity.y


def draw():
    x = []
    y = []
    for i in particles:
        x.append(i.position.x)
        y.append(i.position.y)
    l.set_data(x,y)


def update_line(num):
    if not control.allstop:
        for i in particles:
            i.update_velocity()
            i.update_position()
            if func(i.position)<func(i.pbest):
                i.pbest.set(i.position.x,i.position.y)
                if func(i.pbest) < func(gbest):
                    gbest.set(i.pbest.x,i.pbest.y)
    draw()
    return l,


def func(value):
    return ((value.x)**2) + ((value.y)**2)


def calc_gbest():
    gbest.set(particles[0].position.x,particles[0].position.y)
    for p in particles:
        if func(p.pbest)<func(gbest):
            gbest.set(p.pbest.x,p.pbest.y)


fig = plt.figure()
no_of_particles=25
control=Control()
particles=[]
for i in range(no_of_particles):
    particles.append(Particle())
gbest=Vector(0,0)
calc_gbest()
l, = plt.plot([],[],'ro')
draw()
plt.axhline(color = 'black', zorder=-1)
plt.axvline(color = 'black', zorder=-1)
plt.xlim(-400, 400)
plt.ylim(-400, 400)
plt.xlabel('X')
plt.ylabel('Y')
plt.title('PSO')
line_ani = animation.FuncAnimation(fig, update_line, frames=25, interval=1)
plt.show()
