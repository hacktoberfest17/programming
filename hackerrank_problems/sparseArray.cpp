// https://www.hackerrank.com/challenges/sparse-arrays
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <unordered_map>
#include <algorithm>
using namespace std;


int main() {
    unordered_map <string, int> m;
    int numberOfLines = 0;
    int numberOfQueries = 0;
    int numberOfQueries_2 = 0;
    string line;
    int numberOfAnswer = 0;

    // Read # of lines first
    cin >> numberOfLines;

    // Read inputs from stdin
    while (numberOfLines--)
    {
	cin >> line;
	std::unordered_map<string,int>::const_iterator entry = m.find(line);
        if (entry == m.end())
	{
		m[line] = 1;
	}
	else
	{
		m[line] = m[line] + 1;
	}
    }

    // Read # of queries
    cin >> numberOfQueries;
    numberOfQueries_2 = numberOfQueries;
    int answer[numberOfQueries];

    // Check in unordered map and print value
    while (numberOfQueries--)
    {
	cin >> line;
	std::unordered_map<string,int>::const_iterator entry = m.find(line);
	if (entry == m.end())
	{
		answer[numberOfAnswer++] = 0;
	}
	else
	{
		answer[numberOfAnswer++] = entry->second;
	}
    }

    for (int i = 0 ; i < numberOfQueries_2 ; i++)
    {
	cout << answer[i] << endl;
    }

    return 0;
}

