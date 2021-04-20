package com.orange.talents.integration.cep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orange.talents.api.model.EnderecoViaCepModel;

@Service
@FeignClient(value = "viacep", url = "https://viacep.com.br/ws/")
public interface CepService {    
    @RequestMapping(method = RequestMethod.GET, value = "{cep}/json/", produces = "application/json")
    EnderecoViaCepModel getCep(@PathVariable("cep") String cep);	
}
