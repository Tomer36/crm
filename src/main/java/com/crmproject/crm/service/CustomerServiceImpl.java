package com.crmproject.crm.service;

import com.crmproject.crm.dto.CustomerDTO;
import com.crmproject.crm.model.Customer;
import com.crmproject.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(customerDTO.getName());
            customer.setEmail(customerDTO.getEmail());
            return customerRepository.save(customer);
        }).orElseGet(() -> {
            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(customerDTO.getName());
            customer.setEmail(customerDTO.getEmail());
            return customerRepository.save(customer);
        });
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}