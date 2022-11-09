int red = 13;
int green = 7;
int gnd = 8;

void setup() {
  pinMode(red, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(gnd, OUTPUT);

  digitalWrite(gnd, LOW);
  
  digitalWrite(red, HIGH);
  digitalWrite(green, HIGH);
  delay(1000);
  digitalWrite(red, LOW);
  digitalWrite(green, LOW);

}

void loop(){
  for(int a = 255; a>=0; a--){
    analogWrite(red, a);
    delay(5859.375);
  };

  for(int b=255; b>=0; b--){
    analogWrite(green, b);
    delay(1171.875);
  };
}
