public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE)
        {
            return dividend == Integer.MIN_VALUE? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1)
        {
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
        {
            divisor = -divisor;
			sign =  -1;
        }
        return sign * helper(dividend, divisor);
    }

    private int helper(int dividend, int divisor)
    {
        if (dividend == 0 || (dividend > 0 && divisor > dividend) || (dividend < 0 && divisor < dividend))
        {
            return 0;
        }
        int p = 1;
        int d = divisor;
        while ((dividend > 0  && d + d > 0 && d + d <= dividend) || (dividend < 0 && d + d < 0 && d + d >= dividend))
        {
            p = p + p;
            d = d + d;
        }
        return p + helper(dividend - d, divisor);
    }
