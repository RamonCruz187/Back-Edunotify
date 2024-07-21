package com.mensajeria.escolar.dto;

import com.mensajeria.escolar.entity.NivelEscolar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EscuelaRequestDto implements Serializable {

    public String name;

    public List<NivelEscolar> schoolLevels;
}
