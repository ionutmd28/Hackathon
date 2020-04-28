public class ResourceNotFoundException extends RuntimeException {

    /**
     * constr.
     * @param id id.
     */
    public ResourceNotFoundException(final int id) {
        super(id + "resource not found");
    }
}
