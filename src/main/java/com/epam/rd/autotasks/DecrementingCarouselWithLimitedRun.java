package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {
    private int limit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int limit) {
        super(capacity);
        this.limit=limit;
    }

    @Override
    public CarouselRun run() {
        if (getState() == 1) {
            return null;
        }
        setState((byte) 1);
        return new CarouselRun(getArr(), 3, limit);
    }
}
