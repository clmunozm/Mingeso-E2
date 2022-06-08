# Mingeso-E2
Métodos/Técnicas de Ingeniería de Software - Evaluación 2

# Instrucciones Ejercicio 1

# Ingresar token de Digital Ocean
export TF_VAR_token_do=

# Crear droplets mediante terraform
terraform apply

# Insertar direcciones ip de los droplets en [webservers]
sudo nano /etc/ansible/hosts

ansible-playbook playbook.yml

