package br.com.desafio.serasa.desafio.config;

import br.com.desafio.serasa.desafio.domain.dto.CampoDTO;
import br.com.desafio.serasa.desafio.domain.dto.RestErrorDTO;
import br.com.desafio.serasa.desafio.domain.enums.MensagemEnum;
import br.com.desafio.serasa.desafio.domain.exception.NegocioException;
import br.com.desafio.serasa.desafio.util.MensagemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@ControllerAdvice()
public class GlobalExceptionHandler {

    @Autowired
    private MensagemUtil messageUtil;
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    private ResponseEntity<RestErrorDTO> methodArgumentNotValidExceptionHandler(Exception ex) {
        logger.info(ex.getMessage());

        BindingResult result = ((MethodArgumentNotValidException) ex).getBindingResult();

        var erros = result.getFieldErrors()
                .stream()
                .map(item -> new CampoDTO(item.getField(), messageUtil.getMessage(MensagemEnum.valueOf(item.getDefaultMessage()))))
                .collect(Collectors.toList());


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(RestErrorDTO.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(messageUtil.getMessage(MensagemEnum.VALIDACAO_CAMPO))
                        .campos(erros)
                        .build());
    }


    @ExceptionHandler({EmptyResultDataAccessException.class})
    @ResponseBody
    private ResponseEntity<RestErrorDTO> emptyResultDataAccessException(Exception e) {
        logger.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(RestErrorDTO.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(messageUtil.getMessage(MensagemEnum.REGISTRO_NAO_ENCONTRADO))
                        .build());
    }

    @ExceptionHandler({ NegocioException.class })
    @ResponseBody
    private ResponseEntity<RestErrorDTO> negocioExceptionHandler(Exception e) {
        logger.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(RestErrorDTO.builder()
                        .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                        .message(messageUtil.getMessage(MensagemEnum.valueOf(e.getMessage())))
                        .build());
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    @ResponseBody
    private ResponseEntity<RestErrorDTO> exceptionHandler(Exception e) {
        logger.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(RestErrorDTO.builder()
                        .status(HttpStatus.SERVICE_UNAVAILABLE.value())
                        .message(messageUtil.getMessage(MensagemEnum.SISTEMA_INDISPONIVEL))
                        .build());
    }

}