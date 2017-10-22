package main

import (
	"testing"
)

func TestFetcher(t *testing.T) {
	invalidURI := fetcher("thisisatest")
	if invalidURI.Error == nil {
		t.Error("Expected invalid URI error.")
	}

	invalidScheme := fetcher("ftp://thisisatest.com")
	if invalidScheme.Error == nil {
		t.Error("Expected invalid scheme error.")
	}

	noHost := fetcher("https://sdf.com")
	if noHost.Error == nil {
		t.Error("Expected no such host error.")
	}
}
