import Foundation

let date = Date()
let calendar = Calendar.current
let month = calendar.component(.month, from: date)
let day = calendar.component(.day, from: date)

if (month == 10 && day == 31){
    print("Happy Halloween!")
}
else if (month == 10){
    print("It's October, but today is not Halloween!")
}
    
else {
    print("It's not October")
}

