package nl.deTesters.googledays.soaptest.restassured.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

/**
 * REST-assured response statuscode family matcher
 */
public class IsInFamily extends TypeSafeMatcher<Integer> {

    private Family family;

    /**
     * Sets the statuscode family to match
     *
     * @param family actual family
     */
    public IsInFamily(Family family) {
        this.family = family;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("in response status code family " + family);
    }

    /**
     * Verifies if the statuscode family matches {@link #family}.
     *
     * @param family expected statuscode family
     * @return boolean
     */
    @Factory
    public static Matcher<Integer> matches(Response.Status.Family family) {
        return new IsInFamily(family);
    }

    /**
     * Verifies if the statuscode is in {@link #family}.
     *
     * @param statuscode expected statuscode
     * @return boolean
     */
    @Override
    protected boolean matchesSafely(Integer statuscode) {
        return Response.Status.Family.familyOf(statuscode).equals(family);
    }

}