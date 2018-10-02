/**
 * Run with "go run performance_comparison.go"
 *
 * Requests 20 websites, in serial order and then goroutine'd.
 */
package main

import (
	"fmt"
	"net/http"
	"sync"
	"time"
)

func main() {
	urls := [20]string{
		"http://wikipedia.org", "http://python.org", "http://fsf.org", "http://usaultimate.org", "http://npr.org",
		"http://reddit.com", "http://nytimes.com", "http://github.com", "http://scala-lang.org",
		"http://weather.gov", "http://apple.com", "http://whatsapp.com", "http://trello.com", "http://spotify.com",
		"http://duckduckgo.com", "http://mozilla.org", "http://canonical.com",
		"http://docker.com", "http://democracynow.org", "http://google.com",
	}
	serial(urls)
	fmt.Println()
	parallel(urls)
}

func parallel(urls [20]string) {
	start := time.Now()
	var wg sync.WaitGroup
	wg.Add(20)
	for _, url := range urls {
		go getAndPrint(url, &wg)
	}
	wg.Wait()
	done := time.Since(start)
	fmt.Printf("Parallel took %s\n", done)
}

func serial(urls [20]string) {
	start := time.Now()
	for _, url := range urls {
		getAndPrint(url)
	}
	done := time.Since(start)
	fmt.Printf("Serial tool %s\n", done)
}

func getAndPrint(url string, wg ...*sync.WaitGroup) {
	response, err := http.Get(url)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(response.StatusCode, url)
	if len(wg) > 0 {
		defer wg[0].Done()
	}
}
