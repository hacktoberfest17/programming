function g = sigmoidGradient(z)

g = zeros(size(z));

g_temp = 1.0 ./ (1.0 + exp(-z));

g = g_temp .* ( 1 - g_temp );

end