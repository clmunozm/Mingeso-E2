# Evaluación 2 Mingeso - Ejercicio 1

terraform {
  required_providers {
    digitalocean = {
      source = "digitalocean/digitalocean"
      version = "2.20.0"
    }
  }
}

#TF_VAR_token_do
variable "token_do" {
    type = string
    description = "Token Digital Ocean"
}

provider "digitalocean" {
  # Configuration options
  token = "${var.token_do}"
}

# Create public key
resource "digitalocean_ssh_key" "public_key" {
  name = "public_key"
  public_key = "${file("/home/claudio/.ssh/id_rsa.pub")}"
}

# Create web servers
resource "digitalocean_droplet" "server1" {
    name = "Servidor-1"
    size = "s-1vcpu-1gb"
    region = "nyc1"
    image = "ubuntu-20-04-x64"
    ssh_keys = ["${digitalocean_ssh_key.public_key.fingerprint}"]
}
resource "digitalocean_droplet" "server2" {
    name = "Servidor-2"
    size = "s-1vcpu-1gb"
    region = "nyc1"
    image = "ubuntu-20-04-x64"
    ssh_keys = ["${digitalocean_ssh_key.public_key.fingerprint}"]
}