SELECT constraint_name FROM information_schema.constraint_column_usage
WHERE table_name = 'user_roles' AND column_name = 'role_id'
AND constraint_name <> 'unique_user_roles';

ALTER TABLE user_roles DROP CONSTRAINT "uk_5q4rc4fh1on6567qk69uesvyf";