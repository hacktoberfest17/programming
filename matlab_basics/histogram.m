a=imread('C:\Users\Public\Pictures\Sample Pictures\koala.jpg');
b=rgb2gray(a);
[row,col]=size(b);
arr=zeros(1,256);
for k=1:256
    count=0;
    for i=1:row
        for j=1:col
            if k == b(i,j)
                count=count+1;
            end
        end
    end
    arr(1,k)=count;
end
plot(arr);
prob=zeros(1,256);
for k=1:256
    prob(1,k) = arr(k)/786432;
end
imtool(b);
plot(prob);
