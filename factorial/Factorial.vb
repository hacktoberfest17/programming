Module Module1

    Sub Main()
        Dim n, i, f As Integer
        Console.Write("Enter a Number: ")
        n = CInt(Console.ReadLine())
        f = 1
        If n < 0 Then
            Console.WriteLine("Factorial of negative number is not possible")
        ElseIf n = 0 Or n = 1 Then
            Console.WriteLine("Factorial of " + n.ToString() + " is 1")
        Else
            For i = 1 To n
                f *= i
            Next
            Console.WriteLine("Factorial of " + n.ToString() + " is " + f.ToString())
        End If
        Console.ReadLine()
    End Sub

End Module
