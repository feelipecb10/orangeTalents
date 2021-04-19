package com.orange.talents.integracao.cep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orange.talents.domain.model.Endereco;

@FeignClient(value = "viacep", url = "https://viacep.com.br/ws/")
public interface CepService {		
    Endereco endereco = new Endereco();
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/", produces = "application/json")
    Endereco getCep(@PathVariable("cep") String cep);	
}
