package com.polytech.touristrootserver.rest.dto;

import com.polytech.touristrootserver.domain.*;
import com.polytech.touristrootserver.domain.enums.OrganizationStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrganizationDto {
    private long id;
    private String fullname;
    private String shortname;
    private String website;
    private String contacts;
    private String information;
    private OrganizationStatus status;
    private Manager manager;
    private List<Image> documents;
    private Image image;
//    private List<NotificationEntry> notificationEntries;
//    private List<NotificationMessage> notificationMessages;

    public static OrganizationDto toDto(Organization organization){
        return OrganizationDto.builder().id(organization.getId()).fullname(organization.getFullname())
                .shortname(organization.getShortname()).website(organization.getWebsite())
                .contacts(organization.getContacts()).information(organization.getInformation())
                .status(organization.getStatus()).manager(organization.getManager())
                .documents(organization.getDocuments()).image(organization.getImage()).build();
    }
    public static Organization fromDto(OrganizationDto organization){
        return Organization.builder().id(organization.getId()).fullname(organization.getFullname())
                .shortname(organization.getShortname()).website(organization.getWebsite())
                .contacts(organization.getContacts()).information(organization.getInformation())
                .status(organization.getStatus()).manager(organization.getManager())
                .documents(organization.getDocuments()).image(organization.getImage()).build();
    }
}
