package com.largehat.admin.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Lion
 * @date 2019-6-5 17:29:57
 */
@Data
@AllArgsConstructor
public class ImgResult  implements Serializable {

    private String img;

    private String uuid;
}
