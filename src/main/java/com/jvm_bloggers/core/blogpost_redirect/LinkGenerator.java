package com.jvm_bloggers.core.blogpost_redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.YearMonth;

import static com.jvm_bloggers.core.blogpost_redirect.RedirectController.REDIRECT_URL_PATH;

@Component
public class LinkGenerator {

    private final String applicationBaseUrl;
    private final String issueUrl;
    private final String topPostsUrl;

    @Autowired
    public LinkGenerator(@Value("${application.baseUrl}") String applicationBaseUrl,
                         @Value("${application.issueUrl}") String issueUrl,
                         @Value("${application.topPostsUrl}") String topPostsUrl) {
        this.applicationBaseUrl = applicationBaseUrl;
        this.issueUrl = issueUrl;
        this.topPostsUrl = topPostsUrl;
    }

    public String generateRedirectLinkFor(String blogPostUid) {
        return applicationBaseUrl + REDIRECT_URL_PATH + "/" + blogPostUid;
    }

    public String generateIssueLink(Long issueNumber) {
        return issueUrl + issueNumber;
    }

    public String generateTopPostsSummaryLink(YearMonth yearMonth) {
        return new StringBuilder(topPostsUrl)
                                .append(yearMonth.getYear())
                                .append("/")
                                .append(yearMonth.getMonthValue())
                                .toString();
    }
}
