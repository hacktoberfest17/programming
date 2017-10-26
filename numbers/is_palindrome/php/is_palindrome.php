<html>
  <body>
    <form action="" method="post">
      Enter a string: <input type="" name="string"><br>
      <input type="submit" value="Submit">
    </form>
  </body>
</html>

<?php

if ( isset($_POST) && !empty($_POST["string"]) )
{
    $string = $_POST["string"];
    $revString = strrev( $string );

    if( $string === $revString )
        print("the string $string is a palindrome");
    else
        print("the string $string is not a palindrome");
}
?>
