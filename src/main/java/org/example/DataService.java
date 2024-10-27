package org.example;

import java.util.List;

public interface DataService<T> {
    List<T> getAll();
}
