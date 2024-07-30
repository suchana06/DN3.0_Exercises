public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer findCustomerById(int id) {
        // Simulate finding a customer by ID
        return new Customer(id, "Customer " + id);
    }
}
