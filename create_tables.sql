CREATE TABLE health_checks (
  check_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  check_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX hc_index ON health_checks (check_datetime);
