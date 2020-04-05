package org.htc.tdvo.model.security;

public class SecurityConstants {
	
	public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/user/create";
    public static final String SESSION_URL = "/api/user/*";
    public static final String UPDATE_PROFILE_URL = "/api/user/updateProfile";
    public static final String UPDATE_DETAILS_URL = "/api/user/updateDetails";
    public static final String UPDATE_USER_PROFILE_DETAILS_URL = "/api/user/updateProfileDetails";
   
    
}
