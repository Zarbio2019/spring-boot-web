package com.programming.techie.springredditclone.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class MailContentBuilder {

    private final TemplateEngine templateEngine;

    // create our email message using the HTML template
    public String build(String message) {
        Context context = new Context();
        context.setVariable("message", message); // "message": email message "${message}" from mailTemplate.html
        return templateEngine.process("mailTemplate", context); // "mailTemplate": name of the html template
    }
}