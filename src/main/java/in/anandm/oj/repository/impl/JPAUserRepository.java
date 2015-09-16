package in.anandm.oj.repository.impl;

import in.anandm.oj.model.EmailId;
import in.anandm.oj.model.User;
import in.anandm.oj.repository.UserRepository;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

public class JPAUserRepository extends JPABaseRepository<User, String> implements
        UserRepository {

    @Override
    public User saveUser(User user) {

        return super.save(user);
    }

    @Override
    public User getUserByEmailId(EmailId emailId) {
        Search search = new Search();
        search.addFilter(Filter.equal("emailId", emailId));
        search.setMaxResults(1);
        return super.searchUnique(search);
    }

}
