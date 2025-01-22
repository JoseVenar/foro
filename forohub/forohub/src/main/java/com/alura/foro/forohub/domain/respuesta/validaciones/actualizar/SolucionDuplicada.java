package com.alura.foro.forohub.domain.respuesta.validaciones.actualizar;

import com.alura.foro.forohub.domain.respuesta.DTOActualizarRespuesta;
import com.alura.foro.forohub.domain.respuesta.Respuesta;
import com.alura.foro.forohub.domain.respuesta.RespuestaRepository;
import com.alura.foro.forohub.domain.topico.Estado;
import com.alura.foro.forohub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada{

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(DTOActualizarRespuesta data, Long respuestaId) {
       if (data.solucion()){
           Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
           var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
           if (topicoResuelto.getEstado() == Estado.CLOSED){
               throw new ValidationException("Este topico ya esta solucionado.");
           }
       }
    }
}


