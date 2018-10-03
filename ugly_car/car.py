from graphics import *
import time
#make a canvas and set it up
canvas=GraphWin("Car", 1600, 600)
canvas.setBackground('white')
w=canvas.getWidth()
h=canvas.getHeight()

def moveAll(shapeList, dx, dy):
    ''' Move all shapes in shapeList by (dx, dy).'''   
    for shape in shapeList: 
        shape.move(dx, dy)
            

def moveAllOnLine(shapeList, dx, dy, repetitions, delay):
    '''Animate the shapes in shapeList along a line.
    Move by (dx, dy) each time.
    Repeat the specified number of repetitions.
    Have the specified delay (in seconds) after each repeat.
    '''
    for i in range(repetitions):
        moveAll(shapeList, dx, dy)
        time.sleep(delay)

#make a function for the car
def car(size):
    
    #make the frame
    frame=Polygon(Point(w/2-size/2,h/2-size/5),
                  Point(w/2+size/2,h/2-size/5),      
                  Point(w/2+size/1.85,h/2+size/100),
                  Point(w/2+size/1.6,h/2+size/100),
                  Point(w/2+size/1.6,h/2+size/5),
                  Point(w/2-size/2,h/2+size/5) )
    frame.setFill('firebrick4')
    frame.draw(canvas)

    #make backseat window
    backWindow=Rectangle(Point(w/2-size/2.1,h/2-size/6),
                         Point(w/2-size/100, h/2))
    backWindow.setFill('cadetblue1')
    backWindow.draw(canvas)
    
    #make frontseat window
    frontWindow=Polygon(Point(w/2+size/100, h/2-size/6),
                        Point(w/2+size/2.1,h/2-size/6),
                        Point(w/2+size/2,h/2),
                        Point(w/2+size/100,h/2))
    frontWindow.setFill('cadetblue1')
    frontWindow.draw(canvas)
    
    #make back tire
    backTire=Circle(Point(w/2-size/3,h/2+size/5), size/12)
    backTire.setFill('gray82')
    backTire.setWidth(9)
    backTire.draw(canvas)
    
    #make front tire
    frontTire=Circle(Point(w/2+size/3,h/2+size/5), size/12)
    frontTire.setFill('gray82')
    frontTire.setWidth(9)
    frontTire.draw(canvas)

    
    #make door handle
    doorHandle=Line(Point(w/2+size/80, h/2+size/20),
                    Point(w/2+size/10, h/2+size/20) )
    doorHandle.setWidth(7)
    doorHandle.draw(canvas)


    #make headlight
    headlight=Oval(Point(w/2+size/1.8,h/2+size/40),
                   Point(w/2+size/1.62,h/2+size/10)
                   )
    headlight.setFill('lightgoldenrod1')
    headlight.draw(canvas)


    #make taillight
    taillight=Rectangle(Point(w/2-size/2,h/2+size/40),
                        Point(w/2-size/2.15,h/2+size/10) )
    taillight.setFill('lightgoldenrod1')
    taillight.draw(canvas)

    #move the car
    carParts=[frame, backWindow, frontWindow, headlight,taillight, doorHandle, backTire, frontTire]
    moveAllOnLine(carParts, 5,0,200,0.01)
    moveAllOnLine(carParts, -2,0,500,0.1)

    
    
