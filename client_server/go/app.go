package main

import(
	"fmt"
	"net/http"
	"log"
)
func main() {
	
	http.HandleFunc("/index", index)

	err := http.ListenAndServe(":8080", nil)

	if err!= nil {
		log.Fatal("Couldn't start server: ",err)
	}
}

func index(w http.ResponseWriter , r *http.Request) {

	if r.Method == "GET" {

		fmt.Fprintf(w , "<h1 style=\"color:blue;\">Hello, World!</h1>")
	}
}