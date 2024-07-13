package com.crmproject.crm.service;

import com.crmproject.crm.dto.CustomerDTO;
import com.crmproject.crm.model.Customer;
import com.crmproject.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getPhone1(),
                        customer.getPhone2(),
                        customer.getTelephone(),
                        customer.getBirthday(),
                        customer.getBusinessId()
                ))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<CustomerDTO> getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> new CustomerDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getPhone1(),
                        customer.getPhone2(),
                        customer.getTelephone(),
                        customer.getBirthday(),
                        customer.getBusinessId()
                ));
    }


    @Override
    public Customer saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(customerDTO.getName());
                    customer.setEmail(customerDTO.getEmail());
                    customer.setPhone1(customerDTO.getPhone1());
                    customer.setPhone2(customerDTO.getPhone2());
                    customer.setTelephone(customerDTO.getTelephone());
                    customer.setBirthday(customerDTO.getBirthday());
                    customer.setBusinessId(customerDTO.getBusinessId());
                    Customer updatedCustomer = customerRepository.save(customer);
                    return new CustomerDTO(
                            updatedCustomer.getId(),
                            updatedCustomer.getName(),
                            updatedCustomer.getEmail(),
                            updatedCustomer.getPhone1(),
                            updatedCustomer.getPhone2(),
                            updatedCustomer.getTelephone(),
                            updatedCustomer.getBirthday(),
                            updatedCustomer.getBusinessId()
                    );
                })
                .orElseGet(() -> {
                    Customer newCustomer = new Customer();
                    newCustomer.setId(id);
                    newCustomer.setName(customerDTO.getName());
                    newCustomer.setEmail(customerDTO.getEmail());
                    newCustomer.setPhone1(customerDTO.getPhone1());
                    newCustomer.setPhone2(customerDTO.getPhone2());
                    newCustomer.setTelephone(customerDTO.getTelephone());
                    newCustomer.setBirthday(customerDTO.getBirthday());
                    newCustomer.setBusinessId(customerDTO.getBusinessId());
                    Customer savedCustomer = customerRepository.save(newCustomer);
                    return new CustomerDTO(
                            savedCustomer.getId(),
                            savedCustomer.getName(),
                            savedCustomer.getEmail(),
                            savedCustomer.getPhone1(),
                            savedCustomer.getPhone2(),
                            savedCustomer.getTelephone(),
                            savedCustomer.getBirthday(),
                            savedCustomer.getBusinessId()
                    );
                });
    }


    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
