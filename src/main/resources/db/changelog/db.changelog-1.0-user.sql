-- liquibase formatted sql

-- changeset madhukartemba:1

CREATE TABLE User (
  email VARCHAR(255) NOT NULL,
  name VARCHAR(255) DEFAULT NULL,
  password VARCHAR(255) NOT NULL,
  registrationMethod VARCHAR(50) NOT NULL,
  emailVerified BOOLEAN DEFAULT TRUE,
  enabled BOOLEAN NOT NULL DEFAULT TRUE,
  accountNonExpired BOOLEAN NOT NULL DEFAULT TRUE,
  accountNonLocked BOOLEAN NOT NULL DEFAULT TRUE,
  credentialsNonExpired BOOLEAN NOT NULL DEFAULT TRUE,
  id CHAR(36) NOT NULL,
  created DATETIME DEFAULT NULL,
  createdBy VARCHAR(255) DEFAULT NULL,
  lastModified DATETIME DEFAULT NULL,
  lastModifiedBy VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uniqueEmail (email)
);

CREATE TABLE UserRole (
  userId CHAR(36) NOT NULL,
  role CHAR(255) NOT NULL,
  PRIMARY KEY (userId, role),
  CONSTRAINT fk_user FOREIGN KEY (userId) REFERENCES User(id)
);