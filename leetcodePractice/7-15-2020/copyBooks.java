/**
 * 抄书问题
 */
public int copyBooks(int[] pages, int k) {
    if (pages == null || pages.length == 0) {
        return 0;
    }
    if (k == 0) {
        return -1;
    }

    int start = 0, end = Integer.MAX_VALUE;

    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (getNumberOfCopiers(pages, mid) <= k) {
            end = midl
        } else {
            start = mid;
        }
    }

    if (getNumberOfCopiers(pages, start) <= k) {
        return start;
    }
    return end;
}

private int getNumberOfCopiers(int[] pages, int limit) {
    int copiers = 0;
    int lastCopied = limit;

    for (int page : pages) {
        if (page > limit) {
            return Integer.MAX_VALUE;
        }
        if (lastCopied + page > limit) {
            copiers++;
            lastCopied = 0;
        }

        lastCopied += page;
    }
    return copiers;
}