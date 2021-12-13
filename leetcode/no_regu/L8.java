class L8 {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int res = 0, i = 0;
        boolean flag = true;
        char tmp = s.charAt(0);
        if (tmp == '+' || tmp == '-') {
            i++;
            if (tmp == '-') flag = false;
        }

        for (; i < s.length() && isNumber(s.charAt(i)); i++) {
            int c = s.charAt(i) - '0';
            
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && c >= 8)) {
                res = flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                return res;
            }
            res = res * 10 + c;
        }

        return res * (flag ? 1 : -1);
    }


    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}