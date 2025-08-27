package org.nomantic.coinengine.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> { // The '<T>' makes this class Generic

    private boolean success;
    private String message;
    private T data; // This field can hold any type of data
}