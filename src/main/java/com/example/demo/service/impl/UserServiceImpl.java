@Override
public User registerUser(User user, String roleName) {
    Role role = roleRepository.findByName(roleName)
            .orElseGet(() -> {
                Role r = new Role();
                r.setName(roleName);
                return roleRepository.save(r);
            });

    user.getRoles().add(role);
    return userRepository.save(user);
}
