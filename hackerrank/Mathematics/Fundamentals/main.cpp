#include <iostream>

using namespace std;

void findPoint();

void maximumDraws();

void handshake();

int gcd(int a, int b);

void possiblePath();

void leonardosPrimeFactors();

int main() {
    leonardosPrimeFactors();
    return 0;
}

void findPoint() {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int p1x, p2x, p1y, p2y;
        int p3x, p3y;
        cin >> p1x >> p1y >> p2x >> p2y;
        p3x = (p2x << 1) - p1x;
        p3y = (p2y << 1) - p1y;
        cout << p3x << " " << p3y << endl;
    }
}

void maximumDraws() {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int k;
        cin >> k;
        int t = k + 1;
        cout << t << endl;
    }
}

void handshake() {
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) {
        int k;
        cin >> k;
        cout << k * (k - 1) / 2 << endl;
    }

}

int gcd(int a, int b) {
    if (a < b) {
        a ^= b ^= a ^= b;
    }
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);

}

void possiblePath() {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int x, y, a, b;
        cin >> a >> b >> x >> y;
        bool possible = gcd(x, y) == gcd(a, b);
        cout << (possible ? "YES" : "NO") << endl;
    }
}

long getPrime(long previous) {
    if (previous < 0) {
        return -1;
    }
    if (previous == 2) {
        return 3;
    }

    while (true) {
        outerloop:
        previous += 2;
        if (previous % 2 == 0) {
            continue;
        }
        for (int i = 3; i < previous; i += 2) {
            if (previous % i == 0) {
                goto outerloop;
            }
        }
        return previous;
    }


}

void leonardosPrimeFactors() {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        long double l, lowest;
        int m;
        long previous;
        m = 0;
        cin >> l;
        if (l == 1) {
            cout << m << endl;
            continue;
        }
        m++;
        if (l == 2) {
            cout << m << endl;
            continue;
        }
        previous = 2;
        lowest = previous;
        while (true) {
            previous = getPrime(previous);
            lowest *= previous;
            if (lowest > l) {
                break;
            }
            m++;
        }
        cout << m << endl;
    }
}