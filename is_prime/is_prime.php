<html>
  <body>
    <form action="" method="post">
      Enter the numer: <input type="" name="number"><br>
      <input type="submit" value="Submit">
    </form>
  </body>
</html>

<?php
$number = $_POST['number'];

$j=0;
for($i=1;$i<=$number;$i++)
{
  if($number % $i == 0)
  {
    $j++;
  }
}

if($j==2)
{
 print("prime");
}
else
{
 print("not a prime");
}
?>
