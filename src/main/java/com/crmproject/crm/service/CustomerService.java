package com.crmproject.crm.service;

import com.crmproject.crm.dto.CustomerDTO;
import com.crmproject.crm.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    Customer saveCustomer(CustomerDTO customerDTO);
    Customer updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);
}
