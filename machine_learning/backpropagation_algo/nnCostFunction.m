function [J grad] = nnCostFunction(nn_params, ...
                                   input_layer_size, ...
                                   hidden_layer_size, ...
                                   num_labels, ...
                                   X, y, lambda)

% Reshape nn_params back into the parameters Theta1 and Theta2, the weight matrices
% for our 2 layer neural network
Theta1 = reshape(nn_params(1:hidden_layer_size * (input_layer_size + 1)), ...
                 hidden_layer_size, (input_layer_size + 1));

Theta2 = reshape(nn_params((1 + (hidden_layer_size * (input_layer_size + 1))):end), ...
                 num_labels, (hidden_layer_size + 1));

% Setup some useful variables
m = size(X, 1);
         
% You need to return the following variables correctly 
J = 0;
Theta1_grad = zeros(size(Theta1));
Theta2_grad = zeros(size(Theta2));

p = zeros(size(X, 1), 1);

h1 = sigmoid([ones(m, 1) X] * Theta1');
h2 = sigmoid([ones(m, 1) h1] * Theta2');

y_vector = [1:num_labels];
y_temp = zeros(m,num_labels);

% if y(5) == 5, then y_temp(5,:) = [0 0 0 0 1 0 0 0 0 0]
for i=[1:m],
    y_temp(i,:) = (y_vector == y(i));
end

J = (-1/m) * (sum(sum(y_temp .* log(h2))) + sum(sum((1-y_temp) .* log(1-h2)))) + (lambda/(2*m)) * (sum(sum(Theta1(:,[2:end]).^2)) + sum(sum(Theta2(:,[2:end]).^2)));

% initialize capital delta matrices
c_delta1 = zeros(size(Theta1));
c_delta2 = zeros(size(Theta2));

for i = 1:m,

% a1 = 401*1
% a2 = 26*1
% a3 = 10*1
% z2 = 25*1
% z3 = 10*1
% delta2 = 25*1
% delta3 = 10*1

    a1 = [1; X(i,:)'];
    z2 = Theta1 * a1;
    a2 = [1; sigmoid(z2)];
    z3 = Theta2 * a2;
    a3 = sigmoid(z3);
    
    delta3 = a3 - ([1:num_labels]' == y(i));

    delta2 = (Theta2(:,2:end)' * delta3) .* sigmoidGradient(z2);

    c_delta1 = c_delta1 + delta2 * a1';
    c_delta2 = c_delta2 + delta3 * a2';
end

Theta1_grad = (1/m) * c_delta1;
Theta2_grad = (1/m) * c_delta2;

% regularization
Theta1_grad(:,2:end) = Theta1_grad(:,2:end) + (lambda/m)*Theta1(:,2:end);
Theta2_grad(:,2:end) = Theta2_grad(:,2:end) + (lambda/m)*Theta2(:,2:end);

% Unroll gradients
grad = [Theta1_grad(:) ; Theta2_grad(:)];


end
