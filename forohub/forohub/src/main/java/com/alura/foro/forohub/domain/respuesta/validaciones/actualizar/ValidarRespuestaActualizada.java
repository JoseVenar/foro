package com.alura.foro.forohub.domain.respuesta.validaciones.actualizar;

import com.alura.foro.forohub.domain.respuesta.DTOActualizarRespuesta;

public interface ValidarRespuestaActualizada {

    public void validate(DTOActualizarRespuesta data, Long respuestaId);

}
