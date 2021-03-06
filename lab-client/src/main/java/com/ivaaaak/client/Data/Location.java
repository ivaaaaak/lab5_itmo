package com.ivaaaak.client.Data;

import java.util.Objects;

public class Location {

    private final Long x; //не null
    private final Integer y; //не null
    private final int z;

    public Location(Long x, Integer y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Location{"
                + "x=" + x
                + ", y=" + y
                + ", z=" + z
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return z == location.z && Objects.equals(x, location.x) && Objects.equals(y, location.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
