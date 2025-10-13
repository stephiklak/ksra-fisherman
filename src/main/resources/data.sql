-- ===============================
-- Users
-- ===============================
INSERT INTO users (id, name, email, password_hash, phone, address, role, created_at, updated_at)
VALUES
  (1, 'Alice Customer', 'alice@example.com', 'hashedpassword1', '1234567890', '123 Main St', 'CUSTOMER', now(), now()),
  (2, 'Bob Technician', 'bob@example.com', 'hashedpassword2', '0987654321', '456 Elm St', 'TECHNICIAN', now(), now()),
  (3, 'Charlie Customer', 'charlie@example.com', 'hashedpassword3', '1112223333', '789 Oak St', 'CUSTOMER', now(), now());

-- ===============================
-- Technicians
-- ===============================
INSERT INTO technicians (id, user_id, skills, experience_years, rating, review_count, availability_status, latitude, longitude, created_at, updated_at)
VALUES
  (1, 2, 'Plumbing, Electrical', 5, 4.5, 10, 'AVAILABLE', 28.6139, 77.2090, now(), now());

-- ===============================
-- Service Requests
-- ===============================
INSERT INTO service_requests (id, customer_id, technician_id, description, latitude, longitude, status, created_at, updated_at)
VALUES
  (1, 1, 1, 'Fix leaking faucet', 28.6139, 77.2090, 'PENDING', now(), now()),
  (2, 3, 1, 'Install ceiling fan', 28.7041, 77.1025, 'ACCEPTED', now(), now());

-- ===============================
-- Payments
-- ===============================
INSERT INTO payments (id, customer_id, service_request_id, amount, status, created_at, updated_at)
VALUES
  (1, 1, 1, 50.0, 'PAID', now(), now()),
  (2, 3, 2, 75.0, 'PENDING', now(), now());

-- ===============================
-- Reviews
-- ===============================
INSERT INTO reviews (id, technician_id, customer_id, rating, comment, created_at, updated_at)
VALUES
  (1, 1, 1, 5, 'Excellent service!', now(), now()),
  (2, 1, 3, 4, 'Good work, arrived late.', now(), now());
